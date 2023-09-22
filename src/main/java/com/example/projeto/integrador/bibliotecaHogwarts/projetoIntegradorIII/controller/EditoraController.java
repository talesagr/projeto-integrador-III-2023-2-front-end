package com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.controller;

import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.EditoraDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.GeneroDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.dto.ResponseDTO;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.orm.Editora;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.EditoraService;
import com.example.projeto.integrador.bibliotecaHogwarts.projetoIntegradorIII.service.GeneroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class EditoraController {
    private final EditoraService editoraService;

    public EditoraController(EditoraService editoraService){
        this.editoraService = editoraService;
    }
    @PostMapping("/editora")
    public ResponseEntity<ResponseDTO> post(@RequestBody EditoraDTO editora){
        try {
            editoraService.addEditora(editora.getEditora());
            return new ResponseEntity<>(
                    new ResponseDTO(editora.getEditora(),"Editora salva com sucesso!"),
                    HttpStatus.OK
            );
        }catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(null, e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/editora")
    public ResponseEntity<List<Editora>> getEditoras(){
        List<Editora> editoras = editoraService.getEditoras();
        return new ResponseEntity<>(editoras, HttpStatus.OK);
    }


    @PutMapping("/editora")
    public ResponseEntity<ResponseDTO> put(@RequestBody EditoraDTO editoraDTO){
        try {
            editoraService.updateEditoraDesc(editoraDTO.getId(),editoraDTO);
            return new ResponseEntity<>(
                    new ResponseDTO(editoraDTO.getEditora(), "Editora atualizada com sucesso!"), HttpStatus.OK
            );
        } catch (Exception e) {
            return new ResponseEntity<>(
                    new ResponseDTO(editoraDTO.getEditora(), e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @DeleteMapping("/editora")
    public ResponseEntity<ResponseDTO> delete(@RequestBody EditoraDTO editoraDTO){
        try {
            editoraService.deleteEditoraByID(editoraDTO.getId());
            return new ResponseEntity<>(
                    new ResponseDTO(editoraDTO.getEditora(), "Editora deletada com sucesso!"),HttpStatus.OK
            );
        } catch (Exception e){
            return new ResponseEntity<>(
                    new ResponseDTO(editoraDTO.getEditora(), "Erro ao deletar editora: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
