package Configuration;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilding {

    public Map<String,String> requestBody = new HashMap<>();

    public void addAttributes_to_queue(String requestName, String attribute,String content,boolean prefix){

        String  temp = null;
        if(prefix){
            temp = "<soap1:"+attribute+">"+content+"</soap1:"+attribute+">";
        }else {
            temp = "<"+attribute+">"+content+"</"+attribute+">";
        }

       requestBody.put(temp,requestName);
    }

    public String getRequest(String requestName){
        String fullRequest = null;
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<String,String> entry : requestBody.entrySet()){
            if(entry.getValue().equals(requestName)){
                builder.append(entry.getKey());
            }
        }
        requestBody.clear();
        return builder.toString();
    }

}
