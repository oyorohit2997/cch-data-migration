package com.oyo.cchdatamigration.cchdatamigration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oyo.platform.hierarchy.HierarchyServiceInterface;
import com.oyo.platform.hierarchy.ThriftException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class HierarcyDataMigration {
    public void read() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("/Users/oyo/Documents/_select_employees_id_as_empId_users_user_profile_id_as_userProfi_201905301539.json");
        EmployeeList employeeList = objectMapper.readValue(file, EmployeeList.class);
        System.out.println(employeeList);
        THttpClient httpClient  = null;
        try {
            httpClient = new THttpClient("http://hierarchy-service.ap-southeast-1.elasticbeanstalk.com/hierarchyService");
        } catch (TTransportException e) {
            e.printStackTrace();
        }
        httpClient.setConnectTimeout(3000);
        TProtocol protocol = new TJSONProtocol(httpClient);
        HierarchyServiceInterface.Client client = new HierarchyServiceInterface.Client(protocol);

//        try{
//            client.registerHierarchy("ACP-PACKAGES","PARENT_HIERARCHY");
//        }
//        catch (Exception e){
//
//        }

//        try {
//            System.out.println(client.getImmediateChildren("ACP-PACKAGES","Call-Centre-hierarchy","38276"));
//            //System.out.println(!client.doesNodeExist("ACP-PACKAGES2","Call-Centre-hierarchy3","4266"));
//        } catch (TException e) {
//            e.printStackTrace();
//        }

//        List<String> parent=new ArrayList<>();
//        List<String> child=new ArrayList<>();
////        Employee e = new Employee();
//        e.setParent_profileId(123);
//        e.setUser_profile_id(1234);
//        try {
//            if(!client.doesNodeExist("ACP-PACKAGES2","Call-Centre-hierarchy3",Long.toString(e.getUser_profile_id()))) {
//                client.createOrUpdateEntity("ACP-PACKAGES2", "Call-Centre-hierarchy3", Long.toString(e.getUser_profile_id()), parent, child);
//            }
//            if(!client.doesNodeExist("ACP-PACKAGES2","Call-Centre-hierarchy3",Long.toString(e.getParent_profileId()))) {
//                client.createOrUpdateEntity("ACP-PACKAGES2", "Call-Centre-hierarchy3", Long.toString(e.getParent_profileId()), parent, child);
//            }
//            client.addRelation("ACP-PACKAGES2", "Call-Centre-hierarchy3",Long.toString(e.getParent_profileId()),Long.toString(e.getUser_profile_id()));
//        } catch (TException e1) {
//            e1.printStackTrace();
//        }
        for(Employee e:employeeList.getEmployees()){
            if(e.getParent_profileId()>0){
                List<String> parent=new ArrayList<>();
                List<String> child=new ArrayList<>();
                try {
                    if(!client.doesNodeExist("ACP-PACKAGES","PARENT_HIERARCHY",Long.toString(e.getUser_profile_id()))) {
                        client.createOrUpdateEntity("ACP-PACKAGES", "PARENT_HIERARCHY", Long.toString(e.getUser_profile_id()), parent, child);
                    }
                    if(!client.doesNodeExist("ACP-PACKAGES","PARENT_HIERARCHY",Long.toString(e.getParent_profileId()))) {
                        client.createOrUpdateEntity("ACP-PACKAGES", "PARENT_HIERARCHY", Long.toString(e.getParent_profileId()), parent, child);
                    }
                    client.addRelation("ACP-PACKAGES", "PARENT_HIERARCHY",Long.toString(e.getParent_profileId()),Long.toString(e.getUser_profile_id()));
                } catch (TException e1) {
                    e1.printStackTrace();
                }
                System.out.println(e.getParent_profileId()+"-->"+e.getUser_profile_id());
            }

        }

    }

}
