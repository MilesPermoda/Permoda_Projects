

# Loading library
library(ggplot2)
library(readr)
library(dplyr)
library(datasets)
library(multcompView)

directory <- getwd()
chromoData <- read.csv(paste(directory,"\\chromoData.CSV",sep=""), header = TRUE, sep = ",", quote = "\"",
                  dec = ".", fill = TRUE, comment.char = "")

# Create a data frame
dataframe <- chromoData

anova <- aov(atgcratio ~ chromosome, data = chromoData)
summary(anova)

tukey <- TukeyHSD(anova)
#print(tukey)

cld <- multcompLetters4(anova, tukey)
#print(cld)

Tk <- group_by(chromoData, chromosome) %>%
  summarise(mean=mean(atgcratio), sd = sd(atgcratio), quant = quantile(atgcratio, probs = 0.5)) %>%
  arrange(desc(chromosome))


cld <- as.data.frame.list(cld$chromosome)
Tk$cld <- cld$Letters

#print(Tk)

png("Graph1.png")
ggplot(chromoData, aes(chromosome, atgcratio)) + 
  stat_boxplot( aes(chromosome, atgcratio), 
                geom='errorbar', linetype=1, width=0.5)+  #whiskers
  geom_boxplot( aes(chromosome, atgcratio)) +
  labs(x="Chromosome", y="Ratio of A's and T's to G's and C's")+
  theme_bw() + 
  theme(panel.grid.major = element_blank(), panel.grid.minor = element_blank()) +
  geom_text(data = Tk, aes(x = chromosome, y = quant, label = cld), size = 3, vjust=-0.5, hjust =0.5)
dev.off()

anova2 <- aov(gccontent ~ chromosome, data = chromoData)
summary(anova2)

tukey2 <- TukeyHSD(anova2)


cld2 <- multcompLetters4(anova2, tukey2)


Tk2 <- group_by(chromoData, chromosome) %>%
  summarise(mean=mean(gccontent), sd = sd(gccontent), quant = quantile(gccontent, probs = 0.5)) %>%
  arrange(desc(chromosome))


cld2 <- as.data.frame.list(cld2$chromosome)
Tk2$cld2 <- cld2$Letters

png("Graph2.png")
ggplot(chromoData, aes(chromosome, gccontent)) + 
  stat_boxplot( aes(chromosome, gccontent), 
                geom='errorbar', linetype=1, width=0.5)+  #whiskers
  geom_boxplot( aes(chromosome, gccontent)) +
  labs(x="Chromosome", y="GC Content")+
  theme_bw() + 
  theme(panel.grid.major = element_blank(), panel.grid.minor = element_blank()) +
  geom_text(data = Tk2, aes(x = chromosome, y = quant, label = cld2), size = 3, vjust=-0.5, hjust =0.5)
dev.off()

png("Graph3.png")
ggplot(chromoData, aes(gccontent, atgcratio, color = chromosome)) +
  geom_point() +
  labs(x="GC Content", y="Ratio of A's and T's to G's and C's")+
  geom_smooth(method=lm,  linetype="dashed",
              color="darkred", fill="navy")+
  theme_bw() + 
  theme(panel.grid.major = element_blank(), panel.grid.minor = element_blank()) 
dev.off()
lin <- lm(gccontent~atgcratio, data = chromoData)
summary(lin)

