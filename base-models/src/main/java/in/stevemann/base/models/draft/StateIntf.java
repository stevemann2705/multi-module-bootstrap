package in.stevemann.base.models.draft;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.util.Assert;

public interface StateIntf extends DraftIntf {

  @JsonIgnore
  State getState();

  @JsonIgnore
  @Override
  default boolean isDraft() {
    Assert.state(getState() != null, "State cannot be null");
    return State.DRAFT.equals(getState());
  }

  @JsonIgnore
  default boolean isActive() {
    Assert.state(getState() != null, "State cannot be null");
    return getState().isActive();
  }
}

