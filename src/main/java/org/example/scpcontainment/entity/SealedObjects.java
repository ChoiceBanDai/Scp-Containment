package org.example.scpcontainment.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@TableName("sealed_objects")
@Schema(name = "SealedObject", description = "超自然封印物信息表")
public class SealedObjects
{

    @TableId(type = IdType.AUTO)
    @Schema(description = "封印物编号", example = "1")
    private Integer objectId;

    @NotBlank(message = "外部封印物ID不能为空")
    @Pattern(regexp = "^SCP-\\d+$", message = "外部封印物ID格式必须为SCP-数字，如SCP-001")
    @Schema(description = "外部封印物ID，如 SCP-001", example = "SCP-001")
    private String externalObjectId;

    @NotBlank(message = "封印物名称不能为空")
    @Pattern(regexp = "^.{1,100}$", message = "封印物名称长度不能超过100个字符")
    @Schema(description = "封印物名称", example = "上帝的左手")
    private String name;

    @Schema(description = "异常性质描述", example = "该物体能无限复制接触到的非生物物质")
    private String description;

    @Schema(description = "收容措施", example = "必须存放于2米厚的铅制容器中，每周检查一次密封性")
    private String containmentProcedure;

    @NotNull(message = "安全等级不能为空")
    @Schema(description = "安全等级", example = "Keter",
            allowableValues = {"Safe", "Euclid", "Keter", "Thaumiel", "Apollyon"})
    private String safetyLevel;

    @NotNull(message = "保密等级不能为空")
    @Min(value = 1, message = "保密等级不能低于1")
    @Max(value = 5, message = "保密等级不能高于5")
    @Schema(description = "保密等级 1~5", example = "5")
    private Integer confidentialityLevel;

    @NotNull(message = "状态不能为空")
    @Schema(description = "当前状态", example = "Contained",
            allowableValues = {"Contained", "Breached", "Destroyed", "Lost"})
    private String status;

    @Schema(description = "当前收容站点ID", example = "3")
    private Integer siteId;

    @Schema(description = "创建时间", example = "2023-01-01T00:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "更新时间", example = "2023-01-02T12:00:00")
    private LocalDateTime updatedAt;
}
