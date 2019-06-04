package com.oyo.cchdatamigration.cchdatamigration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oyo.workforce.*;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class CsvUtils {
    public void read(){

        ObjectMapper objectMapper = new ObjectMapper();

        File file = new File("/Users/oyo/Documents/callcentre_organization_structures_201905161909.json");

        try {
            CchList cchList = objectMapper.readValue(file, CchList.class);
            THttpClient httpClient  = new THttpClient("http://prod-acppr-wms-api.ap-southeast-1.elasticbeanstalk.com/callcentre_hierarchy/");
            httpClient.setConnectTimeout(3000);
            TProtocol protocol = new TJSONProtocol(httpClient);
            TCallCentreHierarchyService.Client client = new TCallCentreHierarchyService.Client(protocol);
            int c=0;
            Map<Long,String> m = new HashMap<>();
            for(Cch cch:cchList.getCchList()){
                TAddEmployeeCallCentreHierarchyInfo tAddEmployeeCallCentreHierarchyInfo = new TAddEmployeeCallCentreHierarchyInfo();
                tAddEmployeeCallCentreHierarchyInfo.setCreatedById(cch.getCreated_by_id());
                tAddEmployeeCallCentreHierarchyInfo.setActive(cch.isActive());
                tAddEmployeeCallCentreHierarchyInfo.setUserProfileId(cch.getUser_profile_id());
                tAddEmployeeCallCentreHierarchyInfo.setLevel1(cch.getLevel_1());
                tAddEmployeeCallCentreHierarchyInfo.setLevel2(cch.getLevel_2());
                tAddEmployeeCallCentreHierarchyInfo.setLevel3(cch.getLevel_3());
                tAddEmployeeCallCentreHierarchyInfo.setLevel4(cch.getLevel_4());

                try {
                    if(cch.getUser_profile_id()==26093181){
                        System.out.println("hi");
                    }
                    client.addEmployeeCallCentreHierarchyInfo(tAddEmployeeCallCentreHierarchyInfo);
                    m.put(cch.getUser_profile_id(),"1");
                }
                catch (TEmployeeAlreadyExists e){
                    System.out.println("EMPLOYEE"+cch.getUser_profile_id()+ " "+e);
                }
                catch (TException e){
                    System.out.println("THRIFT"+cch.getUser_profile_id()+ " "+e);
                }
                catch (Exception e){
                    System.out.println("GENERAL"+cch.getUser_profile_id()+ " "+e);
                }

            }
            System.out.println(m.size());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        }
    }
}