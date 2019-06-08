package com.battybuilds.kafkaproducer.config;

import com.battybuilds.kafkaproducer.avro.model.AvroHttpRequest;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class AvroSerializer {
    public byte[] serialize(AvroHttpRequest request) {
        SpecificDatumWriter<AvroHttpRequest> writer = new SpecificDatumWriter<>(AvroHttpRequest.class);
        byte[] bytes = new byte[0];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Encoder binaryEncoder = EncoderFactory.get().binaryEncoder(outputStream, null);
        try {
            writer.write(request, binaryEncoder);
            binaryEncoder.flush();
            bytes = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }
}
