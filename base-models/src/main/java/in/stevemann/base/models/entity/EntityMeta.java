package in.stevemann.base.models.entity;

import static in.stevemann.base.models.entity.EntityMeta.Fields;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import in.stevemann.base.models.draft.State;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
    Fields.ID,
    Fields.SCHEMA_VERSION,
    Fields.NAME,
    Fields.DESCRIPTION,
    Fields.ACTIVE,
    Fields.TAGS,
    Fields.AUDIT
})
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class EntityMeta {

  @JsonProperty(value = Fields.SCHEMA_VERSION, access = JsonProperty.Access.READ_ONLY)
  private int schemaVersion = 1;

  @Size(max = 60)
  @NotEmpty
  @NotNull
  private String name;

  @JsonProperty(Fields.DESCRIPTION)
  private String description;

  @JsonProperty(Fields.TAGS)
  @Valid
  private List<String> tags = new ArrayList<>();

  @JsonProperty(Fields.ACTIVE)
  private Boolean active = true;

  @NotNull
  @JsonProperty(Fields.STATE)
  private State state = State.ACTIVE;

  @JsonProperty(value = Fields.AUDIT)
  private Audit audit;

  public static final class Fields {

    public static final String NAME = "name";

    public static final String SCHEMA_VERSION = "schema_version";

    public static final String DESCRIPTION = "description";

    public static final String TAGS = "tags";

    public static final String ACTIVE = "active";

    public static final String ID = "id";

    public static final String AUDIT = "audit";

    public static final String STATE = "state";

    private Fields() {}
  }
}

