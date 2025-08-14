package org.example.scpcontainment.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.scpcontainment.entity.Members;
import org.example.scpcontainment.mapper.MembersMapper;
import org.example.scpcontainment.service.IMembersService;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl extends ServiceImpl<MembersMapper, Members> implements IMembersService
{

}
