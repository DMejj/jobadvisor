package jaumebalmes.net.jobadvisor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JobAdvisorAPI {

    //empresa
    @GET("/empresa/{id}")
    Call<Empresa> getEmpresa(@Path("id") String id);

    @POST("/empresa")
    Call<Empresa> createEmpresa(@Body Empresa empresa);

    @PUT("/empresa")
    Call<Empresa> updateEmpresa(@Body Empresa empresa);

    @DELETE("/empresa/{id}")
    Call<Empresa> deleteEmpresa(@Path("id") String id);

    @GET("/empresa/poblacio/{poblacio}/sector/{sector}")
    Call <List<Empresa>>getLlocsEmpresa (@Path("poblacio") String poblacio, @Path("sector")String sector);

    @GET("/empresa/sector/{sector}")
    Call <List<Empresa>>getEmpresaSector (@Path("sector") String sector);

    @GET("/empresa/poblacio/{poblacio}")
    Call <List<Empresa>>getEmpresaPoblacio (@Path("poblacio") String poblacio);

    @GET("/empresa/name/{name}")
    Call <List<Empresa>>getEmpresaNom (@Path("nom") String nom);

    //lloc

    @GET("/lloc/{id}")
    Call<Lloc> getLloc(@Path("id") Integer id);

    @POST("/lloc")
    Call<Lloc> createLloc(@Body Lloc lloc);

    @PUT("/lloc")
    Call<Lloc> updateLloc(@Body Lloc lloc);

    @DELETE("/lloc/{id}")
    Call<Lloc> deleteLloc(@Path("id") Integer id);

    @PUT("/lloc/{idLloc}/empresa/{idEmpresa}")
    Call <List<Lloc>>assignLloc (@Path("idLloc") Integer idLloc, @Path("idEmpresa")Integer idEmpresa);

    @GET("/empresa/{id}/lloc")
    Call <List<Lloc>>getLloc (@Path("sector") String sector);

    //Opinio

    @GET("/opinio/{id}")
    Call<Opinio> getoOpinio(@Path("id") Integer id);

    @POST("/Opinio")
    Call<Opinio> createOpinio(@Body Opinio opinio);

    @PUT("/opinio")
    Call<Opinio> updateOpinio(@Body Opinio opinio);

    @DELETE("/opinio/{id}")
    Call<Opinio> deleteOpinio(@Path("id") Integer id);

    @PUT("/opinio/{idOpinio}/lloc/{idLloc}/usuari/{idUsuari}")
    Call<Opinio>assignOpinio (@Path("idOpinio") Integer idOpinio, @Path("idLloc")Integer idLloc, @Path("idUsuari") Integer idUsuari);

    @GET("/opinio/empresa/{id}")
    Call <List<Opinio>>getOpinioEmpresa (@Path("id") Integer id);

    @GET("/opinio/lloc/{id}")
    Call <List<Opinio>>getOpinioLloc (@Path("id") Integer id);

    @GET("/opinio/lloc/{idlloc}/empresa/{idempresa}")
    Call <List<Opinio>>getOpinioLlocEmpresa (@Path("id") Integer id);


    @GET("/usuari/{nom}/password/{psw}")
    Call<Usuari> dologin(@Query("nom") String nom, @Query("psw") String psw);

}
