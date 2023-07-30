package in.stevemann.base.models.draft;

import in.stevemann.base.models.entity.Entity;

public enum State {
  ACTIVE,
  DRAFT,
  INACTIVE;

  public boolean isActive() {
    return ACTIVE.equals(this);
  }

  public static boolean isActive(Entity entity) {
    return entity.getMeta().getState().isActive();
  }
}

