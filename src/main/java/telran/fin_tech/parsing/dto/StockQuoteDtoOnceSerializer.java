package telran.fin_tech.parsing.dto;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;

public class StockQuoteDtoOnceSerializer 
extends JsonSerializer<StockQuoteDtoOnce> 
{
@Override
	public void serialize(StockQuoteDtoOnce value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        gen.writeStringField("date", value.getDate().toString());
        
        gen.writeStringField("open", value.getOpen());
        gen.writeStringField("high", value.getHigh());
        gen.writeStringField("close", value.getClose());
        gen.writeStringField("volume", value.getVolume());

        gen.writeEndObject();
        
    }

}
