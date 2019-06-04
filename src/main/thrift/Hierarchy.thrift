namespace java com.oyo.platform.hierarchy

exception ThriftException {
  1: i32 errorCode,
  2: string message
}

service HierarchyServiceInterface {
  bool registerHierarchy(1:string nameSpace, 2:string name) throws (1: ThriftException ise)
  bool createOrUpdateEntity(1:string nameSpace, 2:string hierarchyName, 3:string node, 4:list<string> parents, 5:list<string> children) throws (1: ThriftException ise)
  bool removeEntity(1:string nameSpace, 2:string hierarchyName, 3:string name) throws (1: ThriftException ise)
  bool addRelation(1:string nameSpace, 2:string hierarchyName, 3:string parent, 4:string child) throws (1: ThriftException ise)
  bool removeRelation(1:string nameSpace, 2:string hierarchyName, 3:string parent, 4:string child) throws (1: ThriftException ise)
  bool doesNodeExist(1:string nameSpace, 2:string hierarchyName, 3:string name) throws (1: ThriftException ise)
  list<string> getAncestors(1:string nameSpace, 2:string hierarchyName, 3:string name) throws (1: ThriftException ise)
  list<string> getImmediateParents(1:string nameSpace, 2:string hierarchyName, 3:string name) throws (1: ThriftException ise)
  list<string> getDescendants(1:string nameSpace, 2:string hierarchyName, 3:string name) throws (1: ThriftException ise)
  list<string> getImmediateChildren(1:string nameSpace, 2:string hierarchyName, 3:string name) throws (1: ThriftException ise)
  list<string> getSiblings(1:string nameSpace, 2:string hierarchyName, 3:string name) throws (1: ThriftException ise)
  list<string> getHierarchy(1:string nameSpace, 2:string hierarchyName) throws (1: ThriftException ise)
}