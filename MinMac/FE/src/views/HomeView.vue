<script setup lang="ts">
import GroupProductVue from '@/components/product/GroupProduct.vue';
import SlideShow from '@/components/SlideShow.vue'
import { onMounted, ref } from 'vue';
import axios from 'axios';
import { categorysData } from '../data';

let menus: any = ref([]);

onMounted(() => {
  menus.value = categorysData;
  getDataCategory();
});

const getDataCategory = (): any => {
  axios.get('http://localhost:8080/api/categories/all')
    .then((response: any) => {
      return response.data;
    })
    .catch((error: any) => {
      console.error(error);
    });
};


</script>

<template>
  <main>
    <div class="content">
      <div class="sub_content">
        <SlideShow></SlideShow>
        <GroupProductVue v-for="menu in menus" :object="menu"></GroupProductVue>
      </div>
    </div>
  </main>
</template>

<style scoped>
.content {
  width: 100%;
  height: auto;
  position: relative;
  background: #E9E9E9;
}

.content .sub_content {
  line-height: 1.5;
  max-width: 1320px;
  width: 1320px;
  margin: auto;
}
</style>
