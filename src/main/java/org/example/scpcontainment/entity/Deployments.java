package org.example.scpcontainment.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("deployments")
@Schema(name = "Deployment", description = "成员部署记录表（记录成员在哪个站点工作）")
public class Deployments {

    @TableId(type = IdType.AUTO)
    @Schema(description = "部署记录编号", example = "1001")
    private Long deploymentId;

    @NotNull(message = "成员编号不能为空")
    @Schema(description = "内部成员编号（关联members表）", example = "5")
    private Integer memberId;

    @NotNull(message = "站点编号不能为空")
    @Schema(description = "内部站点编号（关联sites表）", example = "3")
    private Integer siteId;

    @Size(max = 50, message = "具体职位长度不能超过50个字符")
    @Schema(description = "具体职位，如“首席研究员”", example = "站点安全主管")
    private String position;

    @Schema(description = "部署日期", example = "2023-03-15T09:00:00")
    private LocalDateTime deploymentDate;

    @Schema(description = "是否当前有效部署", example = "true")
    private Boolean isActive;

    @Schema(description = "记录创建时间", example = "2023-03-15T09:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "记录更新时间", example = "2023-03-16T14:30:00")
    private LocalDateTime updatedAt;
}
