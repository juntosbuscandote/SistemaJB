///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package pe.am.spring.rest;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

import java.net.URI;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.Iterator;

import pe.am.spring.entity.BeanDS;
import pe.am.spring.entity.Global;
import pe.am.spring.entity.ServiceLogicException;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import com.google.gson.Gson;
import java.net.URISyntaxException;
import java.util.Map;
///**
// *
// * @author User
// */

public abstract class AbstractRestClient {

    protected static Logger logger = Logger.getLogger(AbstractRestClient.class);

    protected <T> T sendGet(String hostUri, String resourcePath, Object object, Class<T> clazz,BeanDS bean) throws ServiceLogicException {
        UriComponentsBuilder ucb = fromUriString(hostUri).path(resourcePath);
        HashMap<String, Object> mappedObject = objectToMap(object, null);
        Iterator<String> keys = mappedObject.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (null != mappedObject.get(key)) {
                ucb.queryParam(key, mappedObject.get(key));
            }
        }
        URI uri = ucb.build().toUri();
        return send(uri, GET, object, clazz,bean);
    }
    
    protected <T> T sendPost(String hostUri, String resourcePath, Object object, Class<T> clazz,BeanDS bean) throws ServiceLogicException {
        try {
            URI uri = new URI(hostUri + resourcePath);
            return send(uri, POST, object, clazz,bean);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
    
    protected void sendPut(String hostUri, String resourcePath, Object object,BeanDS bean) throws ServiceLogicException {
        try {
            URI uri = new URI(hostUri + resourcePath);
            send(uri, PUT, object, String.class,bean);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    static HashMap<String, Object> objectToMap(Object object, String prefix) {
        HashMap<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> mappedObject = mapper.convertValue(object, Map.class);
        Iterator<String> keys = mappedObject.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = mappedObject.get(key);
            key = prefix == null ? key : prefix + "." + key;
            if (value instanceof Map) {
                map.putAll(objectToMap(value, key));
            } else {
                map.put(key, value);
            }
        }
        return map;
    }

    static <T> T send(URI uri, HttpMethod httpMethod, Object object, Class<T> clazz,BeanDS bean) throws ServiceLogicException {
        try {
            logger.info("send.uri=" + uri);
            logger.info("send.method=" + httpMethod);
            logger.info("send.data=" + object);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("CadenaConexion", bean.getCadenaConexion());
            headers.set("id", bean.getId());
            HttpEntity httpEntity = new HttpEntity(object, headers);
            
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<T> response = restTemplate.exchange(uri, httpMethod, httpEntity, clazz);

            logger.info("send.response.statusCode=" + response.getStatusCode());
            logger.info("send.response.body=" + response.getBody());
            return response.getBody();
        } catch (HttpClientErrorException e) {
            logger.error("send.error.statusCode=" + e.getStatusCode());
            logger.error("send.error.body=" + e.getResponseBodyAsString());

            Gson gson = new Gson();
            ServiceLogicException sle = gson.fromJson(e.getResponseBodyAsString(), ServiceLogicException.class);
            if (sle.getCodigoError() != null) {
                throw sle;
            } else {
                throw e;
            }
        }
    }
    
    
    // Métodos auxiliares
//    protected <T> T sendGet(String hostUri, String resourcePath, Object object, Class<T> clazz) throws ServiceLogicException {
//        UriComponentsBuilder ucb = fromUriString(hostUri).path(resourcePath);
//        HashMap<String, Object> mappedObject = objectToMap(object, null);
//        Iterator<String> keys = mappedObject.keySet().iterator();
//        while (keys.hasNext()) {
//            String key = keys.next();
//            if (null != mappedObject.get(key)) {
//                ucb.queryParam(key, mappedObject.get(key));
//            }
//        }
//        URI uri = ucb.build().toUri();
//        return send(uri, GET, object, clazz);
//    }
//    
//    protected <T> T sendPost(String hostUri, String resourcePath, Object object, Class<T> clazz) throws ServiceLogicException {
//        try {
//            URI uri = new URI(hostUri + resourcePath);
//            return send(uri, POST, object, clazz);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e.getMessage(), e);
//        }
//    }
//    
//    protected void sendPut(String hostUri, String resourcePath, Object object) throws ServiceLogicException {
//        try {
//            URI uri = new URI(hostUri + resourcePath);
//            send(uri, PUT, object, String.class);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e.getMessage(), e);
//        }
//    }
    
//    static <T> T send(URI uri, HttpMethod httpMethod, Object object, Class<T> clazz) throws ServiceLogicException {
//        try {
//            logger.info("send.uri=" + uri);
//            logger.info("send.method=" + httpMethod);
//            logger.info("send.data=" + object);
//
//            HttpHeaders headers = new HttpHeaders();
//            Global global=new Global();
//            System.out.println(global.getCadenaConexion());
//            HttpEntity httpEntity = new HttpEntity(object, headers);
//            
//            RestTemplate restTemplate = new RestTemplate();
//            ResponseEntity<T> response = restTemplate.exchange(uri, httpMethod, httpEntity, clazz);
//
//            logger.info("send.response.statusCode=" + response.getStatusCode());
//            logger.info("send.response.body=" + response.getBody());
//            return response.getBody();
//        } catch (HttpClientErrorException e) {
//            logger.error("send.error.statusCode=" + e.getStatusCode());
//            logger.error("send.error.body=" + e.getResponseBodyAsString());
//
//            Gson gson = new Gson();
//            ServiceLogicException sle = gson.fromJson(e.getResponseBodyAsString(), ServiceLogicException.class);
//            if (sle.getCodigoError() != null) {
//                throw sle;
//            } else {
//                throw e;
//            }
//        }
//    }
}
