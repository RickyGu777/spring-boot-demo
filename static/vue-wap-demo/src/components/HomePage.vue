<template>
  <div class="homePage">
    <el-timeline>
      <el-timeline-item v-for="data in diaryList" :key="data.uuid" :timestamp="data.createDate" placement="top">
        <el-card>
          <h4 @click="routerTo(data.uuid)">{{ data.title }}</h4>
          <p @click="routerTo(data.uuid)">最后更新于{{ data.modiDate }}</p>
        </el-card>
      </el-timeline-item>
    </el-timeline>
  </div>
</template>

<script>
  import {selectDiaryList} from '@/request/api';

  export default {
    name: "HomePage",
    created: function () {
      this.selectDiaryList();
    },
    data() {
      return {
        diaryList: [],
        diary: {'page': 1, 'size': 10},
      };
    },
    methods: {
      async selectDiaryList() {
        let newVar = await selectDiaryList(this.diary);
        this.diaryList = newVar.data.list;
      },
      routerTo(data) {
        this.$router.push({
          name: `DiaryDetail`,
          params: {
            data: data
          }
        });
      }
    }
  }
</script>
