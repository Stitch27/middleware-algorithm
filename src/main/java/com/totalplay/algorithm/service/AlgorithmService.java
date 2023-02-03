package com.totalplay.algorithm.service;

import java.util.List;
import java.util.Arrays;
import java.util.Base64;
import java.util.ArrayList;
import javax.crypto.Cipher;
import java.security.MessageDigest;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.http.HttpStatus;
import com.totalplay.algorithm.model.Value;
import com.totalplay.algorithm.model.Result;
import com.totalplay.algorithm.model.Request;
import com.totalplay.algorithm.model.Response;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

@Service
public class AlgorithmService {

    public ResponseEntity<Response> encryption(String header, Request request) {

        List<Value> values;

        Result result = new Result();

        Response response = new Response();

        try {

            if (!header.trim().isEmpty()) {

                if (request.getValues().size() > 0) {

                    Value value;

                    values = new ArrayList<>();

                    List<Value> list = request.getValues();

                    for (Value element : list) {

                        if(!element.getValue().trim().isEmpty()){

                            value = new Value();

                            String encrypt = algorithmEncrypt(element.getValue(), header);

                            value.setValue(encrypt);

                            values.add(value);

                        }

                        else{

                            values = new ArrayList<>();

                            result.setCode("400");
                            result.setDescription("Valores incompletos.");

                            response.setResult(result);
                            response.setValues(values);

                            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

                        }

                    }

                    result.setCode("100");
                    result.setDescription("Petición realizada con éxito.");

                    response.setResult(result);
                    response.setValues(values);

                    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

                } else {

                    values = new ArrayList<>();

                    result.setCode("300");
                    result.setDescription("Sin valores por encriptar.");

                    response.setResult(result);
                    response.setValues(values);

                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


                }

            } else {

                values = new ArrayList<>();

                result.setCode("200");
                result.setDescription("Ingresar header.");

                response.setResult(result);
                response.setValues(values);

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

            }


        } catch (Exception e) {

            values = new ArrayList<>();

            result.setCode("-51");
            result.setDescription("Excepción validar solicitud.");

            response.setResult(result);
            response.setValues(values);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
    }

    public ResponseEntity<Response> decryption(String header, Request request) {

        List<Value> values;

        Result result = new Result();

        Response response = new Response();

        try {

            if (!header.trim().isEmpty()) {

                if (request.getValues().size() > 0) {

                    Value value;

                    values = new ArrayList<>();

                    List<Value> list = request.getValues();

                    for (Value element : list) {

                        if(!element.getValue().trim().isEmpty()){

                            value = new Value();

                            String decrypt = algorithmDecrypt(element.getValue(), header);

                            value.setValue(decrypt);

                            values.add(value);

                        }else{

                            values = new ArrayList<>();

                            result.setCode("400");
                            result.setDescription("Valores incompletos.");

                            response.setResult(result);
                            response.setValues(values);

                            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


                        }

                    }

                    result.setCode("100");
                    result.setDescription("Petición realizada con éxito.");

                    response.setResult(result);
                    response.setValues(values);

                    return new ResponseEntity<>(response, HttpStatus.ACCEPTED);

                } else {

                    values = new ArrayList<>();

                    result.setCode("300");
                    result.setDescription("Sin valores por desencriptar.");

                    response.setResult(result);
                    response.setValues(values);

                    return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);


                }

            } else {

                values = new ArrayList<>();

                result.setCode("200");
                result.setDescription("Ingresar header.");

                response.setResult(result);
                response.setValues(values);

                return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

            }


        } catch (Exception e) {

            values = new ArrayList<>();

            result.setCode("-51");
            result.setDescription("Excepción validar solicitud.");

            response.setResult(result);
            response.setValues(values);

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
    }

    private SecretKeySpec createKey(String key) throws Exception {

        byte[] encryptedByte = key.getBytes("UTF-8");

        MessageDigest message = MessageDigest.getInstance("SHA-1");

        encryptedByte = message.digest(encryptedByte);

        encryptedByte = Arrays.copyOf(encryptedByte, 16);

        SecretKeySpec secret = new SecretKeySpec(encryptedByte, "AES");

        return secret;
    }

    private String algorithmEncrypt(String data, String key) throws Exception {

        SecretKeySpec secret = this.createKey(key);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, secret);

        byte[] byteData = data.getBytes("UTF-8");

        byte[] encryptedByte = cipher.doFinal(byteData);

        String result = Base64.getEncoder().encodeToString(encryptedByte);

        return result;
    }

    private String algorithmDecrypt(String data, String key) throws Exception {

        SecretKeySpec secret = this.createKey(key);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");

        cipher.init(Cipher.DECRYPT_MODE, secret);

        byte[] byteData = Base64.getDecoder().decode(data);

        byte[] decryptedByte = cipher.doFinal(byteData);

        String result = new String(decryptedByte);

        return result;
    }

}
