package ru.job4j.breach.isp;

public interface Camera {

    void makePhoto();

    void recordVideo();

    void recordAudio();

}

class DigitalCamera implements Camera {

    @Override
    public void makePhoto() {
        /*
         */
    }

    @Override
    public void recordVideo() {
        /*
         */
    }

    @Override
    public void recordAudio() {
        /*
         */
    }

}

class VideoCamera implements Camera {

    @Override
    public void makePhoto() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void recordVideo() {
        /*
         */
    }

    @Override
    public void recordAudio() {
        /*
         */
    }

}

class Zenith11 implements Camera {

    @Override
    public void makePhoto() {
        /*
         */
    }

    @Override
    public void recordVideo() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void recordAudio() {
        throw new UnsupportedOperationException();
    }

}

/*
В интерфейсе Camera обозначено три метода, однако старые фото-камеры вроде Зенита не могут снимать видео и писать аудио, и далеко не все видео-камеры делают фото. Следовало бы разделить на несколько интерфейсов.
 */