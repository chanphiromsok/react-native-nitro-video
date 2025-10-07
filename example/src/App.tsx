import { useEffect } from 'react';
import { View, StyleSheet } from 'react-native';
import { VideoView, createNitroPlayer } from 'react-native-nitro-video';

const player = createNitroPlayer(
  'https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4'
);
export default function App() {
  useEffect(() => {
    return () => {
      player.release();
    };
  }, []);
  return (
    <View style={styles.container}>
      <VideoView player={player} style={styles.box} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
