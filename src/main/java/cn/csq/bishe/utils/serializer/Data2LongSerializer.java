package cn.csq.bishe.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName : Data2LongSerializer
 * @Author : CSQ
 * @Date: 2020-03-14 16:20
 */
public class Data2LongSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        //date ----  >>>long
        jsonGenerator.writeNumber(date.getTime() / 1000);

    }
}
