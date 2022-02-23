package v1.models.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UpdateRequestExtend {

    private UpdateRequest updateRequest;

    private String unique_extend;

}
