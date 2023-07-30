package in.stevemann.testapplication;

import in.stevemann.base.crud.EntityRepository;
import in.stevemann.spring.commons.config.MongoComponent;
import org.springframework.stereotype.Repository;

@MongoComponent
@Repository
public interface TestRepository extends EntityRepository<TestEntity> {
}
