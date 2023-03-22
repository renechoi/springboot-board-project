//package kosta.boot.board.config.adapter;
//
//import java.lang.reflect.Type;
//import java.text.SimpleDateFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
//
//import com.google.gson.JsonDeserializationContext;
//import com.google.gson.JsonDeserializer;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParseException;
//import com.google.gson.JsonPrimitive;
//import com.google.gson.JsonSerializationContext;
//import com.google.gson.JsonSerializer;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//public class GsonLocalDateTimeAdapter implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {
//
//
//    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//    @Override
//    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
//        System.out.println("src = " + src);
////        return new JsonPrimitive(src.toString());
//        return new JsonPrimitive(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(src));
////        return new JsonPrimitive(formatter.format(src));
//    }
//
//    @Override
//    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//        System.out.println("json = " + json);
//        return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
//    }
//
//
//
//
//
//
//
//}