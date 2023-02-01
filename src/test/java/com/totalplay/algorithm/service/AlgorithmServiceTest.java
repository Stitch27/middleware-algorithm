package com.totalplay.algorithm.service;

import java.util.List;
import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import com.totalplay.algorithm.model.Value;
import com.totalplay.algorithm.model.Request;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@RunWith(SpringRunner.class)
class AlgorithmServiceTest {

    @Autowired
    private AlgorithmService algorithmService;

    @Test
    void encryption() {

        Request request = new Request();

        List<Value> values = new ArrayList<>();

        values.add(new Value("Eva"));

        values.add(new Value("Dariana"));

        request.setValues(values);

        assertEquals(algorithmService.encryption("", request).getStatusCodeValue(), 400);

    }

    @Test
    void decryption() {

        List<Value> values = new ArrayList<>();

        values.add(new Value("MNmcAhhqSCwsRtMmBNOpVQ=="));

        assertEquals(algorithmService.decryption("TWljcm9zZXJ2aWNpb3MgTWlkZGxld2FyZQ==",
                new Request(values)).getStatusCode(), HttpStatus.ACCEPTED);

    }

}