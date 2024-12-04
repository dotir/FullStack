package com.libreriapi.libreirapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreriapi.libreirapi.entities.Editorial;
import com.libreriapi.libreirapi.exceptions.ResourceNotFoundException;
import com.libreriapi.libreirapi.models.EditorialCreateDTO;
import com.libreriapi.libreirapi.repositories.EditorialRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    public Editorial createEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    //usar EditorialCreateDTO
    public Editorial createEditorial(EditorialCreateDTO editorialCreateDTO) {
        Editorial editorial = new Editorial();
        editorial.setEditorialActiva(editorialCreateDTO.isEditorialActiva());
        editorial.setNombreEditorial(editorialCreateDTO.getNombreEditorial());
        return editorialRepository.save(editorial);
    }

    public List<Editorial> getAllEditorials() {
        return editorialRepository.findAll();
    }

    public Optional<Editorial> getEditorialById(Long id) {
        return editorialRepository.findById(id);
    }

    public Editorial updateEditorial(Long id, Editorial editorialDetails) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();
        editorial.setNombreEditorial(editorialDetails.getNombreEditorial());
        editorial.setEditorialActiva(editorialDetails.isEditorialActiva());
        return editorialRepository.save(editorial);
    }

    public void darBajaEditorial(Long id) {
        Editorial editorial = editorialRepository.findById(id).orElseThrow();
        editorial.setEditorialActiva(false);
        editorialRepository.save(editorial);
    }

    public void deleteEditorial(Long id) {
        editorialRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Editorial getOne(Long id) {
        return editorialRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Editorial not found with id: " + id));

    }
}
