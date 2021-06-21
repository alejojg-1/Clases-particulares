package com.ceiba.configuracion;

import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;
import com.ceiba.agenda.servicio.ServicioActualizarAgenda;
import com.ceiba.agenda.servicio.ServicioCrearAgenda;
import com.ceiba.agenda.servicio.ServicioEliminarAgenda;
import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.curso.servicio.ServicioActualizarCurso;
import com.ceiba.curso.servicio.ServicioCrearCurso;
import com.ceiba.curso.servicio.ServicioEliminarCurso;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }


    @Bean
    public ServicioCrearCurso servicioCrearCurso(RepositorioCurso repositorioCurso) {
        return new ServicioCrearCurso(repositorioCurso);
    }

    @Bean
    public ServicioActualizarCurso servicioActualizarCurso(RepositorioCurso repositorioCurso) {
        return new ServicioActualizarCurso(repositorioCurso);
    }
    @Bean
    public ServicioEliminarCurso servicioEliminarCurso(RepositorioCurso repositorioCurso) {
        return new ServicioEliminarCurso (repositorioCurso);
    }



    @Bean
    public ServicioCrearAgenda servicioCrearAgenda(RepositorioAgenda repositorioAgenda) {
        return new ServicioCrearAgenda(repositorioAgenda);
    }

    @Bean
    public ServicioActualizarAgenda servicioActualizarAgenda(RepositorioAgenda repositorioAgenda) {
        return new ServicioActualizarAgenda(repositorioAgenda);
    }
    @Bean
    public ServicioEliminarAgenda servicioEliminarAgenda(RepositorioAgenda repositorioAgenda) {
        return new ServicioEliminarAgenda (repositorioAgenda);
    }





	

}
