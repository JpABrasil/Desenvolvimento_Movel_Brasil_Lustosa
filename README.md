# Sobre o Projeto
## Objetivo:
A definir
## Requisitos:
A definir
## Protótipos:
A definir
# Explicações sobre o Android
Essa seção tem como objetivo deixar guardado explicações sobre como a estrutura do projeto funciona
## Pastas e Arquivos:
* build.gradle -> Configurações Globais do Gradle
* settings.gradle -> Quais Módulos fazem parte do projeto
* app (Módulo Principal):
	* src(Código-fonte):
		* main - Pasta principal para código fonte:
			* java | kotlin - Contém os arquivos de código
			* res - Recursos visuais e de interface do app
				* drawable - Imagens e Vetores
				* layout - XML que definem interface do usuário
				* mipmap - Ícones do aplicativo em diferentes resoluções
				* values - Definições reutilizaveis, cores, strings, estilos
			* AndroidManifest.xml - Declara informações do aplicativo, como permissões e atividades
		* build.gradle - Arquivo de configuração especifico do módulo app 
## Componententes de um Aplicativo Android:
Cada tipo de componente tem uma finalidade distinta e tem um ciclo de de vida distinto que define como um componente é criado e destruído
### Activities:
Ponto de entrada para interação com usuário, Exs: Mostrar uma lista, Escrever um email, ler email,... Trabalham juntas para formar a experiência do usuário coesa no aplicativo de e-mail, contudo cada uma é independente uma da outra. Qualquer outro app pode iniciar uma atividade no nosso app.
Uma atividade facilita as principais interações a seguir entre sistema e aplicativo:
* Acompanhar o que o usuário considera importante no momento (o que está na tela) para que o sistema continua executando o processo que hospeda a atividade.
* Saber quais processos usados anteriormente contêm atividades interrompidas aos quais o usuário pode retornar e priorizando esses processos mais para manter a disponibilidade.
* Ajudar o app a lidar com a interrupção do processo para que o usuário possa retornar às atividades com o estado anterior restaurado.
* Oferecer aos aplicativos uma maneira de implementar fluxos de usuários entre si e para que o sistema coordenar esses fluxos. O principal exemplo disso é o compartilhamento.
Toda Activity segue a Lógica de arquivos:
1. Arquivo .kt (Kotlin) → Lógica da tela -> Deve implementar uma subclasse da classe Activity
2. Arquivo .xml (Layout) → Interface gráfica da tela
3. AndroidManifest.xml → Declara a Activity para o sistema

### Serviços:
Um serviço é um ponto de entrada de uso geral para manter um app em execução em segundo plano. por vários motivos. É um componente executado em segundo plano para executar ou realizar trabalho para processos remotos. Serviços não apresentam uma interface do usuário.
Exs: um serviço pode tocar música em segundo plano enquanto o usuário está em um app diferente ou ele pode buscar dados na rede sem bloquear a interação do usuário com uma atividade. Outra componente, como uma atividade, pode iniciar o serviço e permitir que ele seja executado ou vinculado a interagir com ele.Devido à flexibilidade deles, os serviços são úteis elementos básicos para todos os tipos de conceitos de sistema de alto nível. Planos de fundo interativos, notificação listeners, protetores de tela, métodos de entrada, serviços de acessibilidade e muitos outros recursos essenciais do sistema são todos criados como serviços que os aplicativos implementam e que o sistema vincula quando são executados.
#### Serviços Iniciados:
Os serviços iniciados dizem ao sistema para mantê-los em execução até que o trabalho seja concluído. Isso pode acontecer para sincronizar alguns dados em segundo plano ou tocar músicas mesmo depois que o usuário sair do app. A sincronização de dados em segundo plano ou a reprodução de músicas representam diferentes tipos de que o sistema gerencia de forma diferente
#### Serviços Vinculados:
 são executados porque algum outro aplicativo (ou o sistema) informou que gostaria de usar o serviço. 
### Broadcast Receivers:
### Provedor de Conteúdo:
Um provedor de conteúdo gerencia um conjunto compartilhado de dados de apps que você pode armazenar em no sistema de arquivos, em um banco de dados SQLite, na Web ou em qualquer outro armazenamento persistente. local em que o pode acessar. Pelo provedor de conteúdo, outros apps podem consultar ou modificar os dados, se o provedor de conteúdo permitir.

## Ativando Componentes:
Uma mensagem assíncrona, chamada de intent, ativa três dos quatro tipos de componentes: atividades, serviços e broadcast receivers. Os intents vinculam componentes individuais uns aos outros no ambiente de execução. Pense nelas como os mensageiros que solicitam uma ação de outros componentes, se o componente pertence ao seu app ou a outro.
Para atividades e serviços, uma intent define a ação a ser executada, como view ou enviar algo e especificar o URI dos dados com ação, entre outras coisas que o que o componente que está sendo iniciado precise saber.
Por exemplo, uma intent pode transmitir uma solicitação de uma para mostrar uma imagem ou abrir uma página da web. Em alguns casos, você pode iniciar um para receber um resultado. Nesse caso, a atividade também retorna o resultado em uma Intent. Também é possível emitir uma intent para que o usuário escolher um contato pessoal e devolvê-lo a você. A intent de retorno inclui um URI que aponta para o contato escolhido.

##Arquivo Manifesto - AndroidManifest.xml:
Antes que o sistema Android possa iniciar um componente de aplicativo, o sistema deve saber que o existe ao ler o arquivo de manifesto AndroidManifest.xml do app. O app declara todos os componentes nesse arquivo, que está na raiz do do projeto do app.
O manifesto faz outras coisas além de declarar os componentes do aplicativo, como o seguinte:
* Identifica todas as permissões do usuário que o app exige, como acesso à Internet ou acesso de leitura aos contatos do usuário.
* Declara o valor mínimo Nível da API exigidos pelo aplicativo com base nas APIs que ele usa.
* Declara os recursos de hardware e software usados ou exigidos pelo app, como câmera, Serviços Bluetooth ou uma tela multitoque.
* Declara as bibliotecas de API a que o app precisa ser vinculado (além do framework do Android) APIs)
### Declarando Componentes:
A principal tarefa do manifesto é informar o sistema sobre os componentes do app. Para exemplo, um arquivo de manifesto pode declarar uma atividade da seguinte forma:
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest ... >
    <application android:icon="@drawable/app_icon.png" ... >
        <activity android:name="com.example.project.ExampleActivity"
                  android:label="@string/example_label" ... >
        </activity>
        ...
    </application>
</manifest>
```
É necessário declarar todos os componentes do aplicativo que usam os elementos a seguir:
* <activity> elementos para atividades
* <service> elementos para serviços
* <receiver> elementos para broadcast receivers
* <provider> elementos para provedores de conteúdo
### Declarar os recursos do componente:

## Funcionamento:
### Iniciando Tela Inicial:
#### TelaInicial.kt - Lógica da Activity:
```kotlin
package com.example.projetofaculdade
import android.os.Bundle //Usado para armazenar o estado da Activity quando o sistema a recria.
import androidx.appcompat.app.AppCompatActivity //Classe base para atividades que usam o suporte a recursos modernos do Android, como temas e barras de açã0
class TelaInicial : AppCompatActivity() { //Define uma classe TelaInicial que herda a classe AppCompactActivity
    override fun onCreate(savedInstanceState: Bundle?) { //Sobrescreve o método onCreate (Chamado ao criar uma Activity), savedInstanceState: Bundle? contém dados salvos da tela anterior, caso a tela seja recriada (como quando o dispositivo é rotacionado).
        super.onCreate(savedInstanceState) //Executa a implementação original do Android antes de adicionar funcionalidades personalizadas.
        setContentView(R.layout.tela_inicial) //setContentView define qual layout XML será exibido pela activity. Esse R acessa recursos na pasta res e .layout na pasta layout o tela_inicial é o arquivo com as definições de interface
    }
}
```
#### tela_inicial.xml - Interface da Activity:
```xml
<?xml version="1.0" encoding="utf-8"?> <!-- Declara que este é um arquivo XML e usa a codificação UTF-8 -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android" <!-- Declara o namespace XML do Android -->
    android:layout_width="match_parent" <!-- Faz o LinearLayout ocupar toda a largura da tela -->
    android:layout_height="match_parent" <!-- Faz o LinearLayout ocupar toda a altura da tela -->
    android:orientation="vertical"> <!-- Define a orientação para empilhar os elementos na vertical -->
    <Button
        android:id="@+id/meuBotao" <!-- Define um ID único para o botão, permitindo acessá-lo no código Kotlin -->
        android:layout_width="wrap_content" <!-- Faz a largura do botão se ajustar ao conteúdo -->
        android:layout_height="wrap_content" <!-- Faz a altura do botão se ajustar ao conteúdo -->
        android:text="@string/clique_aqui" /> <!-- Define o texto do botão usando um valor do arquivo strings.xml -->
</LinearLayout> <!-- Fecha o LinearLayout -->
```
#### AndroidManifest.xml - Declaração das Activities:
```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">
    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.ProjetoFaculdade"
        tools:targetApi="31">
        <!-- Definição da Activity principal -->
        <activity
            android:name=".TelaInicial" <!-- Conecta com TelaInicial.kt -->
            android:exported="true"
            android:theme="@style/Theme.ProjetoFaculdade"> <!-- Define o tema -->
            <intent-filter>
                <action android:name="android.intent.action.MAIN" /> <!-- Indica que é a tela inicial -->
                <category android:name="android.intent.category.LAUNCHER" /> <!-- Faz aparecer no menu do Android -->
            </intent-filter>
        </activity>
    </application>
</manifest>

```


