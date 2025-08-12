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
@TableName("members")
@Schema(name = "Member", description = "组织成员信息表")
public class Members
{

    @TableId(type = IdType.AUTO)
    @Schema(description = "成员编号", example = "1")
    private Integer memberId;

    @NotBlank(message = "外部成员ID不能为空")
    @Pattern(regexp = "^M-\\d+$", message = "外部成员ID格式必须为M-数字，如M-00456")
    @Schema(description = "外部成员ID，如 M-00456", example = "M-00456")
    private String externalMemberId;

    @NotBlank(message = "姓名或代号不能为空")
    @Pattern(regexp = "^.{1,50}$", message = "姓名或代号长度不能超过50个字符")
    @Schema(description = "姓名或代号", example = "Dr. Bright")
    private String name;

    @NotNull(message = "角色不能为空")
    @Schema(description = "成员角色", example = "Researcher",
            allowableValues = {"Researcher", "Security", "Agent", "Administrator", "O5_Council"})
    private String role;

    @NotNull(message = "保密等级不能为空")
    @Min(value = 1, message = "保密等级不能低于1")
    @Max(value = 5, message = "保密等级不能高于5")
    @Schema(description = "保密等级 1~5", example = "3")
    private Integer clearanceLevel;

    @NotBlank(message = "密码哈希值不能为空")
    @Schema(description = "密码哈希值（BCrypt）", example = "$2a$10$vW9Enp0UvzV3yD1Y6aZ7.eW5jJ9qQ3xR1sT2uV3wX4yZ5aB6cD7eF")
    private String passwordHash;

    @NotNull(message = "状态不能为空")
    @Schema(description = "成员状态", example = "Active",
            allowableValues = {"Active", "Inactive", "KIA", "Converted"})
    private String status;

    @Schema(description = "创建时间", example = "2023-01-01T00:00:00")
    private LocalDateTime createdAt;

    @Schema(description = "更新时间", example = "2023-01-02T12:00:00")
    private LocalDateTime updatedAt;
}

