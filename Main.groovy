import groovy.json.JsonSlurper

class Main{

    private static Map parser(String line){
        def VMmap = [:]
        while(line.length() > 0) {
            def key = ""
            def value = ""
            boolean version = false
            while (line.take(1) != "," && line.length() > 0 ) {
                if (line.take(1) == ":" && line.length() > 0) {
                    version = true;
                    line = line.drop(1)
                } else {
                    if (version) {
                        value += line.take(1);
                    } else {
                        key += line.take(1);
                    }
                    line = line.drop(1);
                }
            }
            line = line.drop(1);
            if(value == ""){
                value = "null"
            }
            VMmap[key] = value
        }
        return VMmap
    }
   /* private static void deploy(Map vm,Map needs,String provider){
        switch(needs["deploymentType"]){
            case "nodes":
                Noeud.deployNode(vm,needs)
                break;
            case "elements":
                Element.deployElement(vm,needs)
                break;
            default:
                Element.deployElement(vm,needs)
                break;
        }
    }
*/
    private static NeedsText,SPvms;
    private spvmMAP
    static void main(String[] args){
        def jsonSlurper = new JsonSlurper()
        def data = jsonSlurper.parse(new File("needs2.json"))
        //def VmMap = data["deployement_info"]["provider"];
        for(def k in data.keySet()){
            def NodeMap = data.get(k).Nodes
            println data.get(k).VM
         //   println()
            Noeud.deployNoeud(NodeMap,data.get(k).VM,data.get(k).provider)
        }

        //deploy(NodeMap,VmMap,(String)data.deployement_info.provider)

      //  println(data.deployement_info.provider)



        /*
        //files init
            //Nodes or coponents to deploy
        File fh1 = new File("needs.txt")
        NeedsText = fh1.readLines()
        def NeedsMap = [:]
            // VM config
        File fh2= new File("SPvm.txt")
        SPvms = fh2.readLines('UTF-8')
        def VmMap = [:]
        //Parsing files
        VmMap = parser(SPvms[0])
        NeedsMap = parser(NeedsText[0])
        //deploy
        deploy(NeedsMap,VmMap)


         */
    }
}