package com.game.controller.IT;

import com.game.entities.Game;
import com.game.entities.kalah.PitId;
import com.game.exceptions.GameIdNotFoundException;
import com.game.service.KalahGameExecutorServiceImpl;
import com.game.service.KalahGameServiceImpl;
import com.game.testdata.GameTestData;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "server.port=0")
@RunWith(SpringRunner.class)
@DirtiesContext
public class KalahaGameControllerTestIT {

    private final Resource jsonForNewGame = new ClassPathResource("NewGame.json");
    private final Resource jsonForInvalidGameId = new ClassPathResource("GameIdNotFound.json");
    private final Resource jsonForInvalidPitId = new ClassPathResource("PitIdNotFound.json");
    @MockBean
    KalahGameServiceImpl kalahGameService;
    @MockBean
    KalahGameExecutorServiceImpl kalahGameExecutorService;
    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    private String asJson(Resource resource) {
        return StreamUtils.copyToString(resource.getInputStream(), Charset.defaultCharset());
    }

    @Test
    public void testGameCreation() throws Exception {

        Game game = GameTestData.getFreshGame();
        game.setId("5d414dcd24e4990006e7c900");
        Mockito.when(this.kalahGameService.createGame())
               .thenReturn(game);
        this.mockMvc.perform(post("/kalah"))
                    .andExpect(status().isCreated())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(content().json(asJson(jsonForNewGame)))
                    .andReturn();
    }

    @Test
    public void testSowPitIndex2() throws Exception {

        Game game = GameTestData.getFreshGame();
        game.setId("5d414dcd24e4990006e7c900");
        Mockito.when(this.kalahGameService.loadGame("5d414dcd24e4990006e7c900"))
               .thenReturn(game);
        Mockito.when(this.kalahGameExecutorService.execute(game, PitId.TWO))
               .thenReturn(game);
        this.mockMvc.perform(put("/kalah/games/5d414dcd24e4990006e7c900/pits/2"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(content().json(asJson(jsonForNewGame)))
                    .andReturn();
    }

    @Test
    public void testSowingTheGameOfInvalidId() throws Exception {

        Mockito.when(this.kalahGameService.loadGame("5d414dcd24e4990006e7c902"))
               .thenThrow(new GameIdNotFoundException("5d414dcd24e4990006e7c902"));

        this.mockMvc.perform(put("/kalah/games/5d414dcd24e4990006e7c902/pits/2"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(content().json(asJson(jsonForInvalidGameId)))
                    .andReturn();
    }

    @Test
    public void testSowingTheGameAtInvalidPitIndex() throws Exception {
        this.mockMvc.perform(put("/kalah/games/5d414dcd24e4990006e7c900/pits/7"))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(content().json(asJson(jsonForInvalidPitId)))
                    .andReturn();
    }
}
