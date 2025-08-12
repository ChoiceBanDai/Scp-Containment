package org.example.scpcontainment.entity;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data//=@Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor。
@TableName("sites")
@Schema(name = "Site", description = "收容站点信息表")
public class Sites
{
    @TableId(type = IdType.AUTO)
    @Schema(description = "站点编号", example = "1")
    private Integer siteId;

    @NotBlank(message = "外部站点ID不能为空")
    @Pattern(regexp = "^Site-\\d+$", message = "外部站点ID格式必须为Site-数字，如Site-77")
    @Schema(description = "外部站点ID，如 Site-77", example = "Site-77")
    private String externalSiteId;

    @NotBlank(message = "站点名称不能为空")
    @Pattern(regexp = "^.{1,100}$", message = "站点名称长度不能超过100个字符")
    @Schema(description = "站点名称", example = "北极收容站")
    private String name;

    @Pattern(regexp = "^.{0,200}$", message = "地理位置描述不能超过200个字符")
    @Schema(description = "地理位置", example = "北极圈北纬78°")
    private String location;

    @NotNull(message = "保密等级不能为空")
    @Min(value = 1, message = "保密等级不能低于1")
    @Max(value = 5, message = "保密等级不能高于5")
    @Schema(description = "保密等级 1~5", example = "3")
    private Integer confidentialityLevel;

    @NotNull(message = "最大收容数量不能为空")
    @Min(value = 0, message = "最大收容数量不能为负数")
    @Schema(description = "最大收容数量", example = "500")
    private Integer capacity;

    @NotNull(message = "安保等级不能为空")
    @Min(value = 1, message = "安保等级不能低于1")
    @Max(value = 5, message = "安保等级不能高于5")
    @Schema(description = "安保等级 1~5", example = "4")
    private Integer securityLevel;

    @Schema(description = "创建时间", example = "2025-08-11T17:25:58")
    private LocalDateTime createdAt;

    @Schema(description = "更新时间", example = "2025-08-11T17:25:58")
    private LocalDateTime updatedAt;
}
