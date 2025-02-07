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
## Activities:
Toda Activity segue a Lógica:
1. Arquivo .kt (Kotlin) → Lógica da tela
2. Arquivo .xml (Layout) → Interface gráfica da tela
3. AndroidManifest.xml → Declara a Activity para o sistema

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


