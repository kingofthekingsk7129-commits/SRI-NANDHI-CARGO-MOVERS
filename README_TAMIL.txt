SRI NANDHI CARGO MOVERS – Android APK Project

இந்த ZIP-ல் Android app source code உள்ளது. இங்கு நேரடியாக APK compile செய்ய Android SDK/Gradle நிறுவப்படவில்லை. எனவே GitHub Actions மூலம் APK உருவாக்க workflow சேர்க்கப்பட்டுள்ளது.

GitHub வழியாக APK பெறுவது:
1. GitHub-ல் புதிய repository உருவாக்கவும்.
2. இந்த ZIP-ஐ extract செய்து உள்ளே உள்ள எல்லா கோப்புகளையும் repository-க்கு upload செய்யவும்.
3. Commit changes செய்யவும்.
4. Repository-ல் Actions tab திறக்கவும்.
5. Build Android APK workflow-ஐ தேர்வு செய்து Run workflow அழுத்தவும் (push செய்தால் தானாகவும் build ஆகும்).
6. Build முடிந்ததும் workflow run-ஐத் திறந்து கீழே Artifacts பகுதியில் Sri-Nandhi-Trip-Book-APK-ஐ download செய்யவும்.
7. ZIP-ஐ extract செய்து app-debug.apk-ஐ Android மொபைலில் திறந்து install செய்யவும். “Install unknown apps” அனுமதி கேட்கலாம்.

கவனம்:
- இது local/offline WebView app. Trip பதிவுகள் அந்த Android app-இன் local storage-ல் இருக்கும்.
- App data clear / uninstall செய்தால் பதிவுகள் அழியலாம். App-இல் உள்ள Backup Download-ஐ அடிக்கடி பயன்படுத்தவும்.
- இது debug APK; Play Store வெளியீட்டுக்கான signed release APK அல்ல.
