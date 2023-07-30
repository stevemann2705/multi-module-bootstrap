package in.stevemann.testapplication;

import in.stevemann.base.crud.EntityCrudController;
import in.stevemann.base.crud.EntityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = TestEntity.SERVICE, produces = MediaType.APPLICATION_JSON_VALUE)
public class TestController extends EntityCrudController<TestEntity> {
  protected TestController(EntityService<TestEntity> testService) {
    super(testService);
  }
}
