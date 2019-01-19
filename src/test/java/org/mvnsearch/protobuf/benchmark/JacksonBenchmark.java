package org.mvnsearch.protobuf.benchmark;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import jmh.mbr.junit5.Microbenchmark;
import org.mvnsearch.protobuf.BaseBenchmark;
import org.mvnsearch.protobuf.UserDO;
import org.openjdk.jmh.annotations.Benchmark;

/**
 * jackson benchmark
 *
 * @author linux_china
 */
@Microbenchmark
public class JacksonBenchmark extends BaseBenchmark {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        // add Jackson datatype for ZonedDateTime
        final SimpleModule module = new SimpleModule();
        objectMapper.registerModule(module);
        objectMapper.setDefaultPrettyPrinter(new MinimalPrettyPrinter());
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
    }

    @Benchmark
    public void benchmark() throws Exception {
        objectMapper.readValue(objectMapper.writeValueAsBytes(userDO), UserDO.class);
    }
}
