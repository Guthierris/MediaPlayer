# Media Player <img align="center" alt="Gut-Js" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/javascript/javascript-plain.svg"><img align="center" alt="Gut-Android" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/androidstudio/androidstudio-original.svg">
O programa tem uma função de media player sendo possivel dar play, pause, stop e mudar o volume da musica que vem pré-definido como volume maximo.
Para funcionar o programa você precisa emular o codigo no android studio, e utilizar de um android connectado usb ou em ambiente virtual.
#
📱 Inteface: você precisa criar 3 botões para play, pause e stop, uma seekbarvolume para alterar o volume da musica, uma imagem opcional referente a musica;
é necessario criar um diretorio (raw) e armazenar as musicas que deseja tocar em formato mp3.
#
Codigo Fonte:

    private MediaPlayer mediaPlayer;
    private SeekBar seekBar, seekBarVolume;
    private AudioManager audioManager;
    private ImageView imageView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.m4);

        seekBarVolume = findViewById(R.id.seekBarVolume);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        seekBarVolume.setMax(maxVolume);
        seekBarVolume.setProgress(curVolume);
        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
    public void tocar(View view){
        mediaPlayer.start();
        imageView3 = (ImageView)findViewById(R.id.imageView3);
        imageView3.setVisibility(View.VISIBLE);
    }
    public void pausar(View view){
        mediaPlayer.pause();
    }
    public void parar(View view){
        mediaPlayer.stop();
        imageView3.setVisibility(View.INVISIBLE);
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.m4);
    }

