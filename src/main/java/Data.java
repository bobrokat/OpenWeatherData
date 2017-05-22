import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {

    public Data() {
    }

    @JsonProperty("main")
    public Object jsonStr;

    public Data(String jsonStr) {
        this.jsonStr = jsonStr;
    }

    public Double parse(){
        JsonParser parser = new JsonParser();
        System.out.println(jsonStr.toString());
        JsonElement jsonElement = parser.parse(jsonStr.toString());
        JsonObject rootObject = jsonElement.getAsJsonObject();
        String temp = rootObject.get("temp").getAsString();
        Double tempDouble = Double.parseDouble(temp);
        tempDouble = Double.valueOf(Math.round(tempDouble - 273));
        return tempDouble;
    }



}
