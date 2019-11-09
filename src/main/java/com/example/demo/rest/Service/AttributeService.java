package com.example.demo.rest.Service;

import com.example.demo.rest.Repository.AttributeRepository;
import com.example.demo.rest.Repository.ProductRepository;
import com.example.demo.rest.Entity.Attribute;
import com.example.demo.rest.Entity.Product;
import com.example.demo.rest.web.DTO.AttributeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;


    public void deleteAttribute(Long attributeId) {
        List<Attribute> attributes = attributeRepository.findAll();
        for (Attribute attribute :
                attributes) {
            if (attribute.getAttribute_id().equals(attributeId)) {
                attributeRepository.delete(attribute);
                System.out.println("////////////////" + attribute.getName());
                break;
            }
        }
    }

    public void save(AttributeDto attributeDto) {

        Attribute attribute = new Attribute(attributeDto.getName(),
                attributeDto.getPrice(),
                attributeDto.getProduct());
        attributeRepository.save(attribute);
    }

}
