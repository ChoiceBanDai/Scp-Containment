package org.example.scpcontainment.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("access_logs")
@Schema(name = "AccessLog", description = "封印物取用申请与日志表（记录成员取用封印物的审批及操作记录）")
public class AccessLogs {

    @TableId(type = IdType.AUTO)
    @Schema(description = "日志记录编号", example = "2001")
    private Long logId;

    @NotNull(message = "成员编号不能为空")
    @Schema(description = "取用成员内部编号（关联members表）", example = "8")
    private Integer memberId;

    @NotNull(message = "封印物编号不能为空")
    @Schema(description = "取用的封印物内部编号（关联sealed_objects表）", example = "12")
    private Integer objectId;

    @NotNull(message = "访问等级不能为空")
    @Min(value = 1, message = "访问等级不能低于1")
    @Max(value = 5, message = "访问等级不能高于5")
    @Schema(description = "本次请求的访问等级（1~5）", example = "4")
    private Integer accessLevel;

    @NotNull(message = "取用目的不能为空")
    @Schema(description = "取用封印物的目的说明", example = "进行季度特性测试与能量读数记录")
    private String purpose;

    @Min(value = 1, message = "预计持续时间不能小于1分钟")
    @Schema(description = "预计取用持续时间（分钟）", example = "60")
    private Integer durationMins;

    @Schema(description = "取用开始时间", example = "2023-05-20T14:00:00")
    private LocalDateTime accessTime;

    @Schema(description = "批准人内部编号（关联members表，可为空）", example = "3")
    private Integer approvalBy;

    @Schema(description = "批准时间", example = "2023-05-20T13:30:00")
    private LocalDateTime approvalTime;

    @NotNull(message = "申请状态不能为空")
    @Schema(description = "申请处理状态", example = "Approved",
            allowableValues = {"Pending", "Approved", "Rejected", "Completed"})
    private String status;

    @Schema(description = "记录创建时间", example = "2023-05-20T10:15:00")
    private LocalDateTime createdAt;

    @Schema(description = "记录更新时间", example = "2023-05-20T15:45:00")
    private LocalDateTime updatedAt;
}
