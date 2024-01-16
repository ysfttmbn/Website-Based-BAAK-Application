package com.example.Kel02.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Kel02.model.IjinKeluar;
import com.example.Kel02.repository.IjinKeluarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IjinKeluarService {

    private final IjinKeluarRepository ijinkeluarRepository;

    @Autowired
    public IjinKeluarService(IjinKeluarRepository ijinkeluarRepository) {
        this.ijinkeluarRepository = ijinkeluarRepository;
    }

    public List<IjinKeluar> getAllIjinKeluar() {
        return ijinkeluarRepository.findAll();
    }

    public Optional<IjinKeluar> getIjinKeluarById(Long id) {
        return ijinkeluarRepository.findById(id);
    }

    public IjinKeluar createIjinKeluar(IjinKeluar ijinkeluar) {
        return ijinkeluarRepository.save(ijinkeluar);
    }

    public IjinKeluar updateIjinKeluar(Long id, IjinKeluar updatedIjinKeluar) {
        Optional<IjinKeluar> existingIjinKeluar = ijinkeluarRepository.findById(id);
        if (existingIjinKeluar.isPresent()) {
        	IjinKeluar ijinkeluar = existingIjinKeluar.get();
            ijinkeluar.setUser(updatedIjinKeluar.getUser());
            ijinkeluar.setKeperluan(updatedIjinKeluar.getKeperluan());
            ijinkeluar.setWaktuBerangkat(updatedIjinKeluar.getWaktuBerangkat());
            ijinkeluar.setWaktuKembali(updatedIjinKeluar.getWaktuKembali());
            ijinkeluar.setStatus(updatedIjinKeluar.getStatus());
            return ijinkeluarRepository.save(ijinkeluar);
        } else {
            // Handle the case when the IjinKeluar with the given id is not found
            return null;
        }
    }
	public IjinKeluar getIjinKeluar(long id) {
		return ijinkeluarRepository.findById(id).get();
	}

    public void deleteIjinKeluar(Long id) {
        ijinkeluarRepository.deleteById(id);
    }
    
    public List<IjinKeluar> getIjinKeluarByUser(Long userId) {
        return ijinkeluarRepository.findByUserId(userId);
    }

	public IjinKeluar findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void save(IjinKeluar existingIjinKeluar) {
		// TODO Auto-generated method stub
		
	}
    
    
}
