package com.peregud.storeapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peregud.storeapp.domain.Shop;
import com.peregud.storeapp.service.ShopService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMocks;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class ShopControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShopService shopService;

    @BeforeEach
    public void setup() {
        Mockito.doAnswer(new ReturnsMocks() {
            public Object answer(InvocationOnMock invocation) {
                return MockUtils.createShops();
            }
        }).when(shopService).getAll();
    }

    @Test
    void displayInfoShop() throws Exception {
        Map<String, Object> params = new HashMap<>();
        mockMvc.perform(get(getUri(params, "/shop/user/info-shop/1"))
                        .headers(getHttpHeaders())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    void displayShopsFullList() throws Exception {
        Map<String, Object> params = new HashMap<>();
        mockMvc.perform(get(getUri(params, "/shop/user/display/full-shop-list"))
                        .headers(getHttpHeaders())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    @Test
    void insertShop() throws Exception {
        Shop shop = new Shop();
        Map<String, Object> params = new HashMap<>();
        mockMvc.perform(post(getUri(params, "/shop/admin/add-shop/new"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(shop)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updateShop() throws Exception {
        Shop shop = new Shop();
        Map<String, Object> params = new HashMap<>();
        mockMvc.perform(put(getUri(params, "/shop/admin/update-shop/1"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(shop)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void deleteShop() throws Exception {
        Map<String, Object> params = new HashMap<>();
        mockMvc.perform(delete(getUri(params, "/shop/admin/delete-shop/2"))
                        .headers(getHttpHeaders())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }

    private HttpHeaders getHttpHeaders() {
        return new HttpHeaders();
    }

    private URI getUri(Map<String, Object> params, String url) {
        return new UriTemplate(url)
                .expand(params);
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
