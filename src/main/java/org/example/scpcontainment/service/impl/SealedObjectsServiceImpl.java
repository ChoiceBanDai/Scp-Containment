package org.example.scpcontainment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.scpcontainment.entity.SealedObjects;
import org.example.scpcontainment.mapper.SealedObjectsMapper;
import org.example.scpcontainment.service.ISealedObjectsService;
import org.springframework.stereotype.Service;

@Service
public class SealedObjectsServiceImpl extends ServiceImpl<SealedObjectsMapper, SealedObjects> implements ISealedObjectsService
{

}
