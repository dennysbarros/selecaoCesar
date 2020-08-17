## Dennys Barros - QA Engineer - Seleção CESAR

### Execução:

Execute a classe CucumberRunner. O browser a ser utilizado deve ser o Google Chrome (foi utilizada a versão _84.0.4147.30_. O driver já está no projeto).
Caso Windows seja usado, descomente as linhas 23 e 24 da classe DriverFactory, e comente as linhas 19 e 20.
Caso seja Linux ou outra versão de ChromeDriver precise ser utlizada, o driver deve ser baixado aqui:
<https://chromedriver.chromium.org/downloads>

### Classes:

#### Util

_util.WebDriverUtils_ - Contém métodos básicos que auxiliam no desenvolvimento de todo o projeto, tais como waitAndClick, mouseOver, etc. <br>
_util.Constants_ - Contém as constantes usadas no projeto <br>
_util.DriverFactory_ - Contém métodos relacionados ao Driver, tais como iniciar o driver, fechar o driver e iniciar o wait.

#### Features:

_Discourse.features_ - Os passos do Discourse foram transformados em cenários de teste escritos em gherkin <br>
_Trivago.features_ - Os passos do Trivago foram transformados em cenários de teste escritos em gherkin

#### Steps (definem as frases escritas nas Features):

_steps.DiscourseSteps_ - Contém os a implementação dos métodos das features do Discourse <br>
_steps.Trivago_ - Contém os a implementação dos métodos das features do Trivago <br>
_steps.Hooks_ - Contém os métodos pra serem rodados antes ou depois das features. Neste projeto, somente @After está sendo utilizado

#### Runner

_runner.CucumberRunner_ - Contém as definições do que deve ser rodado e onde estão definidos os steps, features, tags, etc

#### Pages (contém os elementos e métodos específicos de cada página, respeitando o padrão de projeto PageObject)

_pages.DiscourseDemoPage_ - Contém o mapping dos elementos e métodos relacionados da página Demo do Discourse <br>
_pages.DiscourseMainPage_ - Contém o mapping dos elementos e métodos relacionados da página inicial do Discourse <br>
_pages.TrivagoSearchPage_ - Contém o mapping dos elementos e métodos relacionados das interações de procura de quartos do Trivago

### Test plan da parte manual pode ser encontrado aqui:
<https://drive.google.com/drive/folders/1IoWIuBv64LgSR8OLJr8AA9q0krV-d6QP>
