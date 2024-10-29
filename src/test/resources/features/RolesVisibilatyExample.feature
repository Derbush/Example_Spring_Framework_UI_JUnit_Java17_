@smoke
Feature: Log into the application under different users

  @test1
  Scenario Outline: Visibility of Modules by "<role>"
    When the user logs into the application as "<role>"
    Then the user is authorized as "<role>"
    Then the user sees <number of modules>
    And the user sees the following sections based on the role: "<My Campaign>", "<My program>", "<Handbook>", "<Finance Block>", "<Photoreport>", "<My files>", "<Help>"
    Examples:
      | role                     | number of modules | My Campaign | My program | Handbook | Finance Block | Photoreport | My files | Help |
      | Admin                    | 5                 | yes         | yes        | yes      | no            | yes         | no       | yes  |
      | Head of Department       | 6                 | yes         | yes        | no       | yes           | yes         | yes      | yes  |
      | Buying Manager           | 5                 | yes         | yes        | yes      | no            | no          | yes      | yes  |
      | Client Manager           | 2                 | yes         | no         | yes      | no            | no          | no       | no   |
      | Buying Manager Assistant | 5                 | yes         | no         | yes      | no            | yes         | yes      | yes  |
      | Production Manager       | 3                 | yes         | no         | no       | no            | no          | yes      | yes  |
      | Client Representative    | 2                 | yes         | no         | yes      | no            | no          | no       | no   |
      | Traffic Manager          | 5                 | yes         | no         | no       | yes           | yes         | yes      | yes  |
