package main.pratha;

import java.util.*;

/**
 * Design Compiler
 *
 * Compile a project
 * Project -> List<Modules>
 *
 * Modules many to many dependency
 * {
 *     A, [C, D],
 *     B, [A, D],
 *     C, [D],
 *     D, []
 * }
 *
 * D, C, A, B
 *
 * Module
 *
 * A, 2
 * B, 2
 * C, 1
 * D, 0
 *
 *
 * null-> D
 * D -> A, C, B
 * C-> A
 * A -> B
 *
 * D, C, A, B
 *
 *
 *
 *
 *
 * {
 *  *     A, [B, D],
 *  *     B, [A, D],
 *  *     C, [D],
 *  *     D, []
 *
 *
 *  null-> D
 *  B -> A
 *  D -> A
 *  * }
 *
 *
 */

public class DependencyCompiler {

    static Map<String, List<Module>> dependents = new HashMap<>();
    static Map<String, Integer> count = new HashMap<>();

    static void  printOrderOfCompilation(List<Module> moduleList){
        for(Module module: moduleList){
            count.put(module.name, module.dependencies.size());

            List<Module> dep;
            if(module.dependencies.isEmpty()){
                if(dependents.containsKey(null)){
                    dep = dependents.get(null);
                }else{
                    dep = new ArrayList<>();
                }
                dep.add(module);
                dependents.put(null, dep);
            } else {
                for(Module dependency: module.dependencies){
                    if(dependents.containsKey(dependency.name)){
                        dep = dependents.get(dependency.name);
                    }else{
                        dep = new ArrayList<>();
                    }
                    dep.add(module);
                    dependents.put(dependency.name, dep);
                }
            }
        }

        printMap(dependents);
    }

    static void  printMap(Map<String, List<Module>> map){
        for(Map.Entry<String, List<Module>> entry: map.entrySet()){
            System.out.println(entry.getKey() +"->"+entry.getValue());
        }
    }

    public static void main(String[] args) {

    }

}

class Module{
    String name;
    List<Module> dependencies;

    public Module(String name, List<Module> dependencies) {
        this.name = name;
        this.dependencies = dependencies;
    }

    @Override
    public String toString() {
        return name ;
    }
}
