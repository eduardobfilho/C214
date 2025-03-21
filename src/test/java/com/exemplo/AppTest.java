package com.exemplo;

import com.google.gson.Gson;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testSerializacaoObjetoParaJson() {
        Gson gson = new Gson();
        App.Objeto objeto = new App.Objeto("Teste", 123);
        String json = gson.toJson(objeto);
        assertNotNull(json);
        assertTrue(json.contains("\"mensagem\":\"Teste\""));
        assertTrue(json.contains("\"numero\":123"));
    }

    @Test
    public void testDesserializacaoJsonParaObjeto() {
        Gson gson = new Gson();
        String json = "{\"mensagem\":\"Teste\", \"numero\":123}";
        App.Objeto objeto = gson.fromJson(json, App.Objeto.class);
        assertNotNull(objeto);
        assertEquals("Teste", objeto.mensagem);
        assertEquals(123, objeto.numero);
    }

    @Test
    public void testSerializacaoObjetoComValoresNulos() {
        Gson gson = new Gson();
        App.Objeto objeto = new App.Objeto(null, 0);
        String json = gson.toJson(objeto);
        assertNotNull(json);
        assertTrue(json.contains("\"mensagem\":null"));
        assertTrue(json.contains("\"numero\":0"));
    }

    @Test
    public void testDesserializacaoJsonComCamposFaltando() {
        Gson gson = new Gson();
        String json = "{\"mensagem\":\"Teste\"}";
        App.Objeto objeto = gson.fromJson(json, App.Objeto.class);
        assertNotNull(objeto);
        assertEquals("Teste", objeto.mensagem);
        assertEquals(0, objeto.numero); // Valor padrão para int
    }

    @Test(expected = com.google.gson.JsonSyntaxException.class)
    public void testDesserializacaoJsonComTipoInvalido() {
        Gson gson = new Gson();
        String json = "{\"mensagem\":\"Teste\", \"numero\":\"abc\"}";
        gson.fromJson(json, App.Objeto.class);
    }
}