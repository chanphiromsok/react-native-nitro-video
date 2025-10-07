import { useEffect, useState } from 'react';
import { View, StyleSheet, Button, Text, SafeAreaView } from 'react-native';
import { VideoView, createNitroPlayer } from 'react-native-nitro-video';

// Sample video URL (Big Buck Bunny - a free sample video)
const videoUrl =
  'https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4';

export default function App() {
  // Single player instance - created only once using lazy initialization
  const [player] = useState(() => createNitroPlayer(videoUrl));
  const [isPlaying, _setIsPlaying] = useState(false);

  useEffect(() => {
    // Cleanup on unmount
    return () => {
      player.release();
    };
  }, [player]);

  const handlePlay = () => {
    player.play();
    // setIsPlaying(true);
  };

  const handlePause = () => {
    player.pause();
    // setIsPlaying(false);
  };

  const handleStop = () => {
    player.stop();
    // setIsPlaying(false);
  };

  return (
    <SafeAreaView style={styles.container}>
      <View style={styles.content}>
        <Text style={styles.title}>🎬 Nitro Video Player Test</Text>

        <Text style={styles.subtitle}>Simple test with one player</Text>

        {/* Video Player View */}
        <View style={styles.videoContainer}>
          <VideoView player={player} style={styles.video} />
        </View>

        {/* Controls */}
        <View style={styles.controls}>
          <Text style={styles.status}>
            Status: {isPlaying ? '▶️ Playing' : '⏸️ Paused'}
          </Text>

          <View style={styles.buttonRow}>
            <Button title="▶️ Play" onPress={handlePlay} />
            <Button title="⏸️ Pause" onPress={handlePause} />
            <Button title="⏹️ Stop" onPress={handleStop} />
          </View>

          <Text style={styles.info}>Testing basic playback controls</Text>
        </View>
      </View>
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#1a1a1a',
  },
  content: {
    flex: 1,
    padding: 20,
    justifyContent: 'center',
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    color: '#fff',
    textAlign: 'center',
    marginBottom: 8,
  },
  subtitle: {
    fontSize: 14,
    color: '#aaa',
    textAlign: 'center',
    marginBottom: 30,
  },
  videoContainer: {
    width: '100%',
    aspectRatio: 16 / 9,
    backgroundColor: '#000',
    borderRadius: 12,
    overflow: 'hidden',
    marginBottom: 30,
  },
  video: {
    flex: 1,
  },
  controls: {
    gap: 20,
  },
  status: {
    fontSize: 18,
    color: '#fff',
    textAlign: 'center',
    fontWeight: '600',
    marginBottom: 10,
  },
  buttonRow: {
    flexDirection: 'row',
    justifyContent: 'center',
    gap: 15,
  },
  info: {
    color: '#888',
    textAlign: 'center',
    marginTop: 20,
    fontSize: 12,
    fontStyle: 'italic',
  },
});
