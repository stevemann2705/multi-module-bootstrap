package in.stevemann.base.models.entity;

import static in.stevemann.base.models.entity.Audit.Fields;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Getter
@Setter
@JsonPropertyOrder({
    Fields.CREATED_ON,
    Fields.CREATED_BY,
    Fields.MODIFIED_ON,
    Fields.MODIFIED_BY,
})
public class Audit {

  @JsonProperty(value = Fields.CREATED_BY)
  @NotEmpty
  private String createdBy;

  @JsonProperty(value = Fields.MODIFIED_BY)
  @NotEmpty
  private String modifiedBy;

  @JsonProperty(value = Fields.CREATED_ON)
  private Instant createdOn;

  @JsonProperty(value = Fields.MODIFIED_ON)
  private Instant modifiedOn;

  public Audit() {}

  public Audit(@NotEmpty String createdBy, Instant createdOn) {
    this.createdBy = createdBy;
    this.createdOn = createdOn;
  }

  public void prepareCreation(String username) {
    setCreatedBy(username);
    Instant createdOn = Instant.now();
    setCreatedOn(createdOn);
    setModifiedOn(createdOn);
    setModifiedBy(username);
  }

  public static Audit create(String username) {
    Audit audit = new Audit();
    audit.prepareCreation(username);
    return audit;
  }

  public void prepareModification(String username) {
    setModifiedOn(Instant.now());
    setModifiedBy(username);
  }

  public static class Fields {

    public static final String CREATED_BY = "created_by";

    public static final String MODIFIED_BY = "modified_by";

    public static final String CREATED_ON = "created_on";

    public static final String MODIFIED_ON = "modified_on";

    private Fields() {}
  }
}

