package main.pratha;


import java.util.*;

/**
 Given a list of departments, each department contains department code and the department code which it belongs to.
 e.g. object of department D1 is a sub-department of C1
 {
 "code": "D1",
 "belongsTo": "C2"
 }

 - One department belongs to only one department.
 - If the department does not belong to any other department, it's the top department.

 Write a method to convert the input list into an object, and we can find the Nth department which a department belongs to.
 e.g.
 A
 /   \
 B1     B2
 /           \
 C1             C2
 /   \
 D1    D2
 The 1st department which D1 belongs to is C2.

 */



class Department{
    String code;
    Department belongsTo;

    //overwrite equals & hashcode  & toString on basis on code
}


public class DepartmentStructure{
    Map<String, Department> departmentMap = new HashMap<>();

    void initializeDepartmentStructure(List<Department> departments) throws Exception {
        for(Department d : departments){
            if(departmentMap.containsKey(d.code)){
                throw new Exception("One department belongs to only one department.");
            }
            departmentMap.put(d.code, d);
        }
    }


    Department departmentBelongsTo(String code, int n){
        Department department = departmentMap.get(code);
        n--;

        while(n > 0 && department != null){
            department = department.belongsTo;
            n--;
        }

        return department;
    }
}


