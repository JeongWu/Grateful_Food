package com.example.demo.service;

import com.example.demo.domain.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.web.Response.StoreListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<StoreListResponseDto> findStore(Store store) {
        return storeRepository.findStore(store).stream()
                .map(StoreListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StoreListResponseDto> findAllCheckin(){
        return storeRepository.findAll_chicken().stream().map(StoreListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StoreListResponseDto> findAllZokbal(){
        return storeRepository.findAll_zokbal().stream().map(StoreListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StoreListResponseDto> findAllKorea(){
        return storeRepository.findAll_korea().stream().map(StoreListResponseDto::new).collect(Collectors.toList());
    }
//
    @Transactional(readOnly = true)
    public List<StoreListResponseDto> findAllPizza(){
        return storeRepository.findAll_pizza().stream().map(StoreListResponseDto::new).collect(Collectors.toList());
    }

}