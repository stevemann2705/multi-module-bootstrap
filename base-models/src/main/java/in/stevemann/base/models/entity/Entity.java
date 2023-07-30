package in.stevemann.base.models.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.stevemann.base.models.draft.State;
import in.stevemann.base.models.draft.StateIntf;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
public abstract class Entity<T> implements EntityIntf, StateIntf {

  @MongoId
  String id;

  @Valid
  @NotNull
  @JsonProperty(Fields.META)
  private EntityMeta meta;

  @Valid
  @JsonProperty(Fields.DATA)
  private T data;

  @Override
  public State getState() {
    return getMeta().getState();
  }

  public void populateDefaults() {}

  public void createAudit(String user) {
    Audit audit = new Audit();
    Instant createdOn = Instant.now();
    audit.setCreatedBy(user);
    audit.setCreatedOn(createdOn);
    audit.setModifiedBy(user);
    audit.setModifiedOn(createdOn);
    this.meta.setAudit(audit);
  }

  public void modifyAudit(String user) {
    Audit audit = this.meta.getAudit();
    audit.setModifiedOn(Instant.now());
    audit.setModifiedBy(user);
  }

  public static class Fields {
    public static final String META = "meta";

    public static final String DATA = "data";

    public static final String ENTITY_TYPE = "entity_type";

    private Fields() {}
  }
}

