package in.stevemann.testapplication;

import in.stevemann.base.crud.EntityRepository;
import in.stevemann.base.crud.EntityService;
import in.stevemann.base.models.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TestService extends EntityService<TestEntity> {

  private final TestRepository testRepository;
  private final KafkaTemplate<String, Event<TestEntity>> kafkaTemplate;

  @Autowired
  protected TestService(EntityRepository<TestEntity> entityRepository, KafkaTemplate<String, Event<TestEntity>> kafkaTemplate, TestRepository testRepository) {
    super(testRepository, kafkaTemplate);
    this.testRepository = testRepository;
    this.kafkaTemplate = kafkaTemplate;
  }

  @Override
  protected String getEntityType() {
    return TestEntity.ENTITY_TYPE;
  }
}
