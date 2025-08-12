package org.example.scpcontainment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.scpcontainment.entity.AccessLogs;
import org.example.scpcontainment.mapper.AccessLogsMapper;
import org.example.scpcontainment.service.IAccessLogsService;
import org.springframework.stereotype.Service;

@Service
public class AccessLogsServiceImpl extends ServiceImpl<AccessLogsMapper, AccessLogs> implements IAccessLogsService
{
}

